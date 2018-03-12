import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

class App extends Component {
constructor(props){
    super(props);
    this.state = {
      CountriesData:'None',
      countries:'None',
      states:'None',
      cities:'None',
      selectedCountry:'Select',
      selectedState:'Select',
      selectedCity:'Select'
    }
    this.CountriesData = this.CountriesData.bind(this); 
    this.handleCountry = this.handleCountry.bind(this); 
    this.handleState = this.handleState.bind(this); 
    //this.handleCity = this.handleCity.bind(this); 
}
async CountriesData(){
  return await axios.get('http://localhost:8080/demo/get').then((response) => {
    if(response.status === 200)
    return response;
    this.setState({CountriesData: response.data});
  }).catch((response)=> {
    return "Error";
  });

}
  componentDidMount() {
   this.CountriesData();
 
  }
  handleCountry(event){
    this.setState({selectedCountry:event.target.value});
    if(this.state.CountriesData !== "None"){
        this.state.CountriesData.map((country) => {
        
        if(country.name === event.target.value){
         
            this.setState({states:country.states});
    
        }}
      );
    

  }}
  handleState(event){
    this.setState({selectedState:event.target.value});
    if(this.state.CountriesData !== "None"){
      this.state.CountriesData.map((country) => {
        country.states.map((state)=> {

          if(state.stateName === event.target.value){
        
            this.setState({cities:state.cities});
    
        }
        });
      }
    );
  
   
  }}
  
  render() {
   
    let selectCountriesBox;
    let selectStatesBox;
    let selectCitiesBox;
   if(this.state.CountriesData !== "None"){

    selectCountriesBox = this.state.CountriesData.map((country) => 
    <option value={country.name}>{country.name}</option>  
  );}
  if(this.state.CountriesData !== "None"){
    if(this.state.states !== "None"){
   selectStatesBox = this.state.states.map((state) => 
    <option value={state.stateName}>{state.stateName}</option>  
  );}else{
    selectStatesBox =<option value="Select">Select</option>
  }}
  
  if(this.state.CountriesData !== "None"){
    if(this.state.cities !== "None"){
   selectCitiesBox = this.state.cities.map((city) => 
    <option value={city.cityName}>{city.cityName}</option>  
  );}
else {
  selectCitiesBox = <option value="Select">Select</option>
}}
  
    return (
      <div className="App">
          <h1 className="App-title">React App</h1>
          <br/>
          <select name = "Countries" onChange={this.handleCountry} style={{width:"200px"}}>
          {selectCountriesBox}
          </select>
          <br/>
          <select name = "States" onChange={this.handleState} style={{width:"200px"}}>
          {selectStatesBox}
          </select>
          <br/>
          <select name = "Cities"style={{width:"200px"}}>
          {selectCitiesBox}
          </select>
          <br/>
      </div>
    );
  }
}

export default App;
