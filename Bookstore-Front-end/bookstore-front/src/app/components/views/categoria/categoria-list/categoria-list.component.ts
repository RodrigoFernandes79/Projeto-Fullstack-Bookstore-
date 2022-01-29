import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import Swal from 'sweetalert2';
import { Categoria } from '../categoria.model';
import { CategoriaService } from '../categoria.service';



@Component({
  selector: 'app-categoria-list',
  templateUrl: './categoria-list.component.html',
  styleUrls: ['./categoria-list.component.scss']
})
export class CategoriaListComponent implements OnInit {
  
  categoria:Observable<Categoria[]>

  categoriaSelecionada:Categoria;

  
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

  delete(categoria:Categoria){
this.categoriaSelecionada =categoria;  
this.categoriaService.getCategoriaById(this.categoriaSelecionada.id)
.subscribe(() =>
    Swal.fire({
      title: 'Você tem certeza que quer apagar a categoria '+  this.categoriaSelecionada.nome +' ?',
      text: "Você não poderá mais reverter isso!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sim, quero apagar!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.categoriaService.deleteCategoriaById(this.categoriaSelecionada.id)
.subscribe(() =>{
        Swal.fire(
         'Apagado!',
          'Categoria ' + this.categoriaSelecionada.nome + ' foi deletada.',
          'success'
          
          
         )
         this.ngOnInit();

        },     
        err=> err.error(Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Cadastro não Deletado! Possui Livros associados.',
        
        })))
  }
  
    
   
    this.ngOnInit();
  }),
 
  
    
)
  }
  update(id:number){
    
    this.router.navigate(['/categorias/update',id])
   
   
    
   
  }
  listarLivros(id:number){
    this.router.navigate(['/categorias/livros',id ])
  }
}


