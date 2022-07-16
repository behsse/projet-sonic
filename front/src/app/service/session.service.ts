import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import Session from '../models/session.model';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  private apiUrl = "http://localhost:8080"

  constructor(private httpClient : HttpClient) { }

  getSessions(): Observable<Session[]>{
    return this.httpClient.get<Session[]>(`${this.apiUrl}/session`);
  }

  getSession(id: number): Observable<Session>{
    return this.httpClient.get<Session>(`${this.apiUrl}/session/id/${id}`);
  }

  createSession(Session: Session): Observable<Session>{
    return this.httpClient.post<Session>(`${this.apiUrl}/session`, Session);
  }

  updateSession(Session: Session): Observable<Session>{
    return this.httpClient.put<Session>(`${this.apiUrl}/session/${Session.id}`, Session);
  }

  deleteSession(id: number): Observable<Session>{
    return this.httpClient.delete<Session>(`${this.apiUrl}/session/${id}`);
  }
}
