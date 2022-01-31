import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLinkActive } from '@angular/router';
import { Observable } from 'rxjs';
import Swal from 'sweetalert2';
import { Categoria } from '../../categoria/categoria.model';
import { CategoriaService } from '../../categoria/categoria.service';
import { LivroService } from '../../livro.service';
import { Livro } from '../livro.model';

@Component({
  selector: 'app-livro-list',
  templateUrl: './livro-list.component.html',
  styleUrls: ['./livro-list.component.scss']
})
export class LivroListComponent implements OnInit {

  livro:Livro[]=[];
  id:number;
  livroSelecionado:Livro = new Livro();

  constructor(private service:LivroService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
  
    this.id =this.route.snapshot.params['id'];
this.mostrarLivro();

  }

  mostrarLivro(){
    
    this.service.getLivroByCategoria(this.id)
    .subscribe((resposta)=>
    this.livro = resposta);
    
  }
  deleteLivro(livro:Livro):void{
    this.livroSelecionado = livro;
    this.service.findLivroById(this.livroSelecionado.id)
    .subscribe(() =>
    Swal.fire({
      title: 'Você tem certeza que quer apagar o livro '+  this.livroSelecionado.titulo +' ?',
      text: "Você não poderá mais reverter isso!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sim, quero apagar!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.deleteLivroById(this.livroSelecionado.id)
.subscribe(() =>{
        Swal.fire(
         'Apagado!',
          'Livro ' + this.livroSelecionado.titulo + ' foi deletado.',
          'success'
          
          
         )
         this.ngOnInit();

        },     
        err=> err.error(Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Livro não pôde ser Deletado!',
        
        })))
  }
  
    
   
    this.ngOnInit();
  }),
 
  
    
)
       
  }
criarLivro():void{
    this.router.navigate(['/categorias/livros/create',this.id]);
  }

  updateLivro(id:number):void{
    this.router.navigate(['/categorias/livros/update',id]);
  }
}
