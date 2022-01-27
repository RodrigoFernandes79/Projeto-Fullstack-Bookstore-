import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import Swal from 'sweetalert2';
import { Categoria } from '../categoria.model';
import { CategoriaService } from '../categoria.service';

@Component({
  selector: 'app-categoria-update',
  templateUrl: './categoria-update.component.html',
  styleUrls: ['./categoria-update.component.scss']
})
export class CategoriaUpdateComponent implements OnInit {
  
  
  id:number;
  categoria:Categoria= new Categoria( );

  
      
    constructor(private service:CategoriaService,private router:Router, private route:ActivatedRoute) { }
  

  ngOnInit(): void {
this.categoria;
  this.id = this.route.snapshot.params['id'];
  this.service.getCategoriaById(this.id).subscribe(resposta => this.categoria = resposta)

  }
alterarCategoriaById():void{
  this.service.updateCategoriaById(this.id,this.categoria).subscribe(resposta =>{
    this.categoria = resposta;
    this.retornaLista();
    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: 'Categoria atualizada com sucesso!',
      showConfirmButton: false,
      timer: 1500
    })
   
    
  },
  err =>{
    this.categoria=err;
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'Não foi possível atualizar esta Categoria!',
      footer: 'Favor verificar todos os campos preenchidos.'
    })
    
  }
  )
}
  retornaLista(){
    this.router.navigate(['categorias']);
  } 
  
}
  

    
   
  

   



   
   


