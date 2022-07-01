import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import Domaine from '../models/domaine.model';

@Injectable({
  providedIn: 'root'
})
export class ModelService {

  private apiUrl = "http://localhost:8080"

  constructor(private httpClient : HttpClient) { }

  getDomaines(): Observable<Domaine[]>{
    return this.httpClient.get<Domaine[]>(`${this.apiUrl}/domaines`);
  }

  getDomaine(id: number): Observable<Domaine>{
    return this.httpClient.get<Domaine>(`${this.apiUrl}/domaines/id/${id}`);
  }

  createDomaine(domaine: Domaine): Observable<Domaine>{
    return this.httpClient.post<Domaine>(`${this.apiUrl}/domaines`, domaine);
  }

  updateDomaine(domaine: Domaine): Observable<Domaine>{
    return this.httpClient.put<Domaine>(`${this.apiUrl}/domaines/${domaine.id}`, domaine);
  }

  deleteDomaine(id: number): Observable<Domaine>{
    return this.httpClient.delete<Domaine>(`${this.apiUrl}/domaines/${id}`);
  }
}
