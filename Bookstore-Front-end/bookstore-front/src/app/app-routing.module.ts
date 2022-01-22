import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoriaListComponent } from './components/views/categoria/categoria-list/categoria-list.component';


import { HomeComponent } from './components/views/home/home.component';


const routes: Routes = [
  
  {path:'', component:HomeComponent},
  {path:'categorias',component:CategoriaListComponent}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
