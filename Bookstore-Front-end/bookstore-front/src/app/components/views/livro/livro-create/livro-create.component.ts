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
 
  constructor(private service:LivroService,private route:ActivatedRoute, private router:Router) { }


  ngOnInit(): void {
    
  }

}
    
    
