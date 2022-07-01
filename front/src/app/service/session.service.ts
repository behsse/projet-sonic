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
    return this.httpClient.get<Session[]>(`${this.apiUrl}/sessions`);
  }

  getSession(id: number): Observable<Session>{
    return this.httpClient.get<Session>(`${this.apiUrl}/sessions/id/${id}`);
  }

  createSession(Session: Session): Observable<Session>{
    return this.httpClient.post<Session>(`${this.apiUrl}/sessions`, Session);
  }

  updateSession(Session: Session): Observable<Session>{
    return this.httpClient.put<Session>(`${this.apiUrl}/sessions/${Session.id}`, Session);
  }

  deleteSession(id: number): Observable<Session>{
    return this.httpClient.delete<Session>(`${this.apiUrl}/sessions/${id}`);
  }
}
