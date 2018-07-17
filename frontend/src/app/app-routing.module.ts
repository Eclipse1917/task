import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BnkseekListComponent} from "./components/bnkseek-list/bnkseek-list.component";

const routes: Routes = [
  {path: '', component: BnkseekListComponent},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
