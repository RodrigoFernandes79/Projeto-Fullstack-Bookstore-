import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLinkActive } from '@angular/router';
import { Observable } from 'rxjs';
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

  constructor(private service:LivroService, private route:ActivatedRoute) { }

  ngOnInit(): void {
  
    this.id =this.route.snapshot.params['id'];
this.mostrarLivro();

  }

  mostrarLivro(){
    
    
    this.service.getLivroByCategoria(this.id)
    .subscribe((resposta)=>
    this.livro = resposta);
    

  }
}
