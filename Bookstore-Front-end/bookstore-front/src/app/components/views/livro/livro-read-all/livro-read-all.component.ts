import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Categoria } from "../../categoria/categoria.model";
import { LivroService } from "../../livro.service";
import { Livro } from "../livro.model";


@Component({
  selector: 'app-livro-read-all',
  templateUrl: './livro-read-all.component.html',
  styleUrls: ['./livro-read-all.component.scss']
})
export class LivroReadAllComponent implements OnInit {

  id:number;
  id_cat:number;
  livro:Livro = new Livro();
categoria:Categoria = new Categoria();

  constructor( private router:ActivatedRoute, private service:LivroService, private route:Router) { }

  ngOnInit(): void {
    
 this.id_cat = this.router.snapshot.params['id'];
    this.id= this.router.snapshot.params['id_liv'];
    this.encontrarLivroPorId();
    
     

  }
encontrarLivroPorId():void{
  this.service.findLivroById(this.id)
  .subscribe((resposta)=> this.livro =resposta);
}
retornaLista():void{
 
  this.route.navigate(['/categorias/livros',this.id_cat]);
}

}
