import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from './categoria/categoria.model';
import { Livro } from './livro/livro.model';


@Injectable({
  providedIn: 'root'
})
export class LivroService {

  private baselivroUrl:string =  'http://localhost:8080/livros'
  private  livroUrl:string = 'http://localhost:8080/livros?categoria='

  constructor(private http:HttpClient) { }

  getLivroByCategoria(id:number ):Observable<Livro[]>{
    
    return this.http.get<Livro[]>(`${this.livroUrl}${id}`);
  }
}
