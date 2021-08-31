import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-et-login',
  templateUrl: './et-login.component.html',
  styleUrls: ['./et-login.component.css']
})
export class EtLoginComponent implements OnInit {

  
  username : String;
  password : String;
  baseUrl : String;
  constructor(private httpClient : HttpClient) { 
    this.username = "abc";
    this.password = "xyz";
    this.baseUrl = "http://localhost:8080/";
  }

  ngOnInit(): void {
  }

  handleLogin(event : Event) {
    console.log("handleLogin");
    console.log(event);
    console.log("Username:"+ this.username+"," + "Password:"+ this.password);
    const user = new User(this.username, this.password);
    const body = JSON.stringify(user);
    console.log(body);
    const headers = {"content-type":"application/json"};
    this.httpClient.post(this.baseUrl + "/handleLogin", body, {"headers" : headers});
    //this.httpClient.post("http://localhost:8080/handleLogin?username=,password=")
  }

}
