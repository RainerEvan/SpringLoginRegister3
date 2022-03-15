import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

export class Employee{
  constructor(
    public id: string,
    public name: string,
    public designation: string,
    public salary: number
  ){}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private httpClient: HttpClient) {}

  getEmployees(){
    let username='maman';
    let password='password';

    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient.get<Employee[]>('http://localhost:8080/employees',{headers});
  }

  public deleteEmployee(employee: Employee){
    let username='maman'
    let password='password'
  
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient.delete<Employee>("http://localhost:8080/employees" + "/"+ employee.id,{headers});
  }

  public createEmployee(employee: Employee){
    let username='maman'
    let password='password'
  
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient.post<Employee>("http://localhost:8080/employees", employee,{headers});
  }
}
