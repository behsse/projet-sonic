import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import Theme from '../models/theme.model';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {

  private apiUrl = "http://localhost:8080"

  constructor(private httpClient : HttpClient) { }

  getThemes(): Observable<Theme[]>{
    return this.httpClient.get<Theme[]>(`${this.apiUrl}/themes`);
  }

  getTheme(id: number): Observable<Theme>{
    return this.httpClient.get<Theme>(`${this.apiUrl}/themes/id/${id}`);
  }

  createTheme(Theme: Theme): Observable<Theme>{
    return this.httpClient.post<Theme>(`${this.apiUrl}/themes`, Theme);
  }

  updateTheme(Theme: Theme): Observable<Theme>{
    return this.httpClient.put<Theme>(`${this.apiUrl}/themes/${Theme.id}`, Theme);
  }

  deleteTheme(id: number): Observable<Theme>{
    return this.httpClient.delete<Theme>(`${this.apiUrl}/themes/${id}`);
  }
}
