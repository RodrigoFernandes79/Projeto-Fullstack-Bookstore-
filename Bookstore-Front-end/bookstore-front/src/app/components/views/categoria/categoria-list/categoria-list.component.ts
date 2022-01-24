import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Categoria } from '../categoria.model';
import { CategoriaService } from '../categoria.service';



@Component({
  selector: 'app-categoria-list',
  templateUrl: './categoria-list.component.html',
  styleUrls: ['./categoria-list.component.scss']
})
export class CategoriaListComponent implements OnInit {
  
  categoria:Observable<Categoria[]>
  
  constructor(private categoriaService:CategoriaService, private router:Router) { }

  ngOnInit(): void {
    this.getCategoria();
  }

  getCategoria():void{
    this.categoria=this.categoriaService.getCategoria();
  }
  irParaCategoriaCreate(){
    this.router.navigate(['/categorias/create']);
  }
}
