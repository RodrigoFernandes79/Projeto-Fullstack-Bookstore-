import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoriaService } from '../../categoria.service';
import { Categoria } from '../categoria.model';


@Component({
  selector: 'app-categoria-list',
  templateUrl: './categoria-list.component.html',
  styleUrls: ['./categoria-list.component.scss']
})
export class CategoriaListComponent implements OnInit {
  
  categoria:Observable<Categoria[]>
  
  constructor(private categoriaService:CategoriaService) { }

  ngOnInit(): void {
    this.getCategoria();
  }

  getCategoria():void{
    this.categoria=this.categoriaService.getCategoria();
  }
}
