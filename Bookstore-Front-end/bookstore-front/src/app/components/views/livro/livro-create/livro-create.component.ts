import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Categoria } from '../../categoria/categoria.model';
import { LivroService } from '../../livro.service';
import { Livro } from '../livro.model';

@Component({
  selector: 'app-livro-create',
  templateUrl: './livro-create.component.html',
  styleUrls: ['./livro-create.component.scss']
})
export class LivroCreateComponent implements OnInit {
  
  livro:Livro = new Livro();
  id:number;

  constructor(private service:LivroService,private route:ActivatedRoute, private router:Router) { }


  ngOnInit(): void {
    
    this.id= this.route.snapshot.params['id'];
    
  }
criarCategoria():void{
  
  this.service.createLivro( this.livro, this.id)
  
  .subscribe(()=>
  
  Swal.fire({
   position: 'top-end',
   icon: 'success',
   title: 'Categoria Salva com Sucesso!',
   showConfirmButton: false,
   timer: 1500
   
 }
 
 ),
 
  ()=>

    
    (
    
    Swal.fire({
   icon: 'error',
   title: 'Oops...',
   text: 'Cadastro não Realizado!',
 
 }))

  ),
  this.cancelaLivro();
 
}

cancelaLivro(){
  this.router.navigate(['/categorias/livros',this.id ]);
}
}
    
    
