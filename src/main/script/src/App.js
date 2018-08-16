import React, {Component} from 'react';
import 'whatwg-fetch';
import logo from './logo.svg';
import './App.css';
import 'axios';

// used axios for making request to backend.
const axios = require('axios');

class App extends Component {

    state = {users: []}

    handleChange = (event) => {
        this.setState({request: event.target.value})
    }
    handleSubmit = (event) => {
        event.preventDefault();
        let request = this.state.request.trim();
        if (!request) {
            return;
        }

        const getUsers = async () => {
            try {
                return await axios.get(`http://localhost:8080/user/search?name=${request}`)
            } catch (e) {
                console.log(e)
            }
        }

        const prepareUsers = async () => {
            const users = await getUsers()

            if (users.data) {
                this.setState({users: users.data});

            } else {
                console.log()
            }
        }

        /* API call to /user/search with request parameter with User's name,  returns

         [{"id":3,"name":"Ada ","phoneNumber":"+109006598745-1223","address":"England"},{"id":9,"name":"Adamon","phoneNumber":"009891212-1222","address":"England"}]

         eg. when search with key 'ada', 'ADA' or 'aDa' is made. */

        prepareUsers()

    }
    render = () => {
        return (
            <div className="App">
                <div className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h2>Who to look up to?</h2>
                </div>
                <div>
                    <form className="App-intro" onSubmit={this.handleSubmit}>
                        <input type="text" onChange={this.handleChange}/>
                        <input type="submit" value="Search"/>
                    </form>
                </div>

                <div>
                    <ul>
                        {this.state.users.map(user =>
                            <li>
                                {user.name}
                            </li>
                        )}
                    </ul>
                </div>

            </div>
        )
    }
}


export default App;
