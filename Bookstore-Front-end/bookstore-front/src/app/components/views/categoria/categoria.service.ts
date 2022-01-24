import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from './categoria.model';


@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  private CategoriaUrl:string = 'http://localhost:8080/categorias'

    constructor(private http:HttpClient){}

    getCategoria():Observable<Categoria[]>{
        return this.http.get<Categoria[]>(this.CategoriaUrl);
    }

  createCategoria(categoria:Categoria):Observable<Categoria>{
    return this.http.post<Categoria>(this.CategoriaUrl, categoria);
  }
}
