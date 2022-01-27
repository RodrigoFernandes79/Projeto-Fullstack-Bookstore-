import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoriaCreateComponent } from './components/views/categoria/categoria-create/categoria-create.component';


import { CategoriaListComponent } from './components/views/categoria/categoria-list/categoria-list.component';
import { CategoriaUpdateComponent } from './components/views/categoria/categoria-update/categoria-update.component';



import { HomeComponent } from './components/views/home/home.component';


const routes: Routes = [
  
  {path:'', component:HomeComponent},
  
  {path:'categorias',component:CategoriaListComponent},
  {path:'categorias/create', component:CategoriaCreateComponent},
  {path:'categorias/update/:id', component:CategoriaUpdateComponent }
 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
