import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Categoria } from '../../categoria/categoria.model';
import { LivroService } from '../../livro.service';
import { Livro } from '../livro.model';

@Component({
  selector: 'app-livro-update',
  templateUrl: './livro-update.component.html',
  styleUrls: ['./livro-update.component.scss']
})
export class LivroUpdateComponent implements OnInit {

  id:number;
  id_cat:string;
  livro:Livro = new Livro();
categoria:Categoria = new Categoria();
  constructor( private router:ActivatedRoute, private service:LivroService, private route:Router) { }

  ngOnInit(): void {
    this.categoria;
 this.id_cat = this.router.snapshot.paramMap.get('/:id');
    this.id= this.router.snapshot.params['id_liv'];
    this.encontrarLivroPorId();
    
     

  }
encontrarLivroPorId():void{
  this.service.findLivroById(this.id)
  .subscribe((resposta)=> this.livro =resposta);
}


  alterarLivroById():void{
    this.service.updateLivroById(this.id,this.livro)
    .subscribe(resposta=> {
    this.livro = resposta;
    
    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: 'Livro '+this.livro.titulo+ ' atualizado com sucesso!',
      showConfirmButton: false,
      timer: 1500
    })
    
  }, 
  err =>{
      this.livro=err;
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Não foi possível atualizar este Livro!',
        footer: 'Favor verificar todos os campos  foram preenchidos corretamente!'
      })
      
    }

    )
    this.retornaLista();
  }

retornaLista():void{
 
  this.route.navigate(['/categorias/livros',this.id_cat]);
}
}


