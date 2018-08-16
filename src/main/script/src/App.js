import React, { Component } from 'react';
import 'whatwg-fetch';
import logo from './logo.svg';
import './App.css';


class App extends Component {



    handleChange = (event) => {
        this.setState( {request: event.target.value} )
    }
    handleSubmit = (event) => {
        event.preventDefault();
        let request = this.state.request.trim();
        if (!request) {
            return;
        }


        //API call to /user/search with request parameter with User's name
        // returns [{"id":3,"name":"Ada ","phoneNumber":"+109006598745-1223","address":"England"}] fof 'ada' search,
        fetch(`http://localhost:8080/user/search?name=${request}`, {mode: "no-cors"})
            .then(response => {
                console.log("response: " + response);
                return response;
             });
            // .then(body => {
            //     alert(body);
            // });

    }
    render = () => {
        return (
            <div className="App">
                <div className="App-header">
                    <img src={logo} className="App-logo" alt="logo" />
                    <h2>Who to look up to?</h2>
                </div>
                <div>
                    <form className="App-intro" onSubmit={this.handleSubmit}>
                        <input type="text" onChange={this.handleChange} />
                        <input type="submit" value="Search" />
                    </form>
                </div>

                {/*<div>*/}

                    {/*<ul>*/}
                        {/*{this.state.request.map(*/}
                            {/*function (user) {*/}
                                {/*return <li> {user.name} </li>*/}
                            {/*}*/}
                        {/*)}*/}
                    {/*</ul>*/}

                {/*</div>*/}
            </div>
        )
    }
}

export default App;
