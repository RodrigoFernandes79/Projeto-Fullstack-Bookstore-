import { compileComponentFromRender2 } from '@angular/compiler/src/render3/view/compiler';
import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoriaCreateComponent } from './components/views/categoria/categoria-create/categoria-create.component';


import { CategoriaListComponent } from './components/views/categoria/categoria-list/categoria-list.component';
import { CategoriaUpdateComponent } from './components/views/categoria/categoria-update/categoria-update.component';



import { HomeComponent } from './components/views/home/home.component';
import { LivroCreateComponent } from './components/views/livro/livro-create/livro-create.component';
import { LivroListComponent } from './components/views/livro/livro-list/livro-list.component';
import { LivroUpdateComponent } from './components/views/livro/livro-update/livro-update.component';


const routes: Routes = [
  
  {path:'', component:HomeComponent},
  
  {path:'categorias',component:CategoriaListComponent},
  {path:'categorias/create', component:CategoriaCreateComponent},
  {path:'categorias/update/:id', component:CategoriaUpdateComponent },
  {path:'categorias/livros/create/:id', component:LivroCreateComponent},
  {path:'categorias/livros/:id', component:LivroListComponent},
  {path:'categorias/livros/update/:id/:id_liv', component:LivroUpdateComponent},
  
 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
