import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cliente-lista',
  templateUrl: './cliente-lista.component.html',
  styleUrls: ['./cliente-lista.component.css']
})
export class ClienteListaComponent implements OnInit {


  constructor(
    private router: Router,
    private route: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
  }

  onNewCadastro(): void {
    this.router.navigate(['main/clientes/cadastro']);
  }

  onDetails(id): void {
    this.router.navigate(["details", id], {relativeTo: this.route});
  }

  onUpdate(id): void {
    this.router.navigate(['update', id], {relativeTo: this.route});
  }
}
