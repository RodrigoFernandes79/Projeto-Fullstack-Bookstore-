import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Categoria } from '../categoria.model';

import { CategoriaService } from '../categoria.service';



@Component({
  selector: 'app-categoria-create',
  templateUrl: './categoria-create.component.html',
  styleUrls: ['./categoria-create.component.scss']
})
export class CategoriaCreateComponent implements OnInit {

  categoria:Categoria = new Categoria();
  
  
  
  constructor(private router:Router , private service:CategoriaService ) { }

  ngOnInit(): void {
  }
  voltarPraListaCateg():void{
    this.router.navigate(['/categorias'])
  }

  

  
  cadastrarCateg(){
    this.service.createCategoria(this.categoria)
    .subscribe(()=>
    Swal.fire({
     position: 'top-end',
     icon: 'success',
     title: 'Categoria Salva com Sucesso!',
     showConfirmButton: false,
     timer: 1500
     
   }
   ),
   
    ()=> Swal.fire({
     icon: 'error',
     title: 'Oops...',
     text: 'Cadastro não Realizado!',
   
   })

   );
   this.voltarPraListaCateg();
   
   
   
   
}


}

