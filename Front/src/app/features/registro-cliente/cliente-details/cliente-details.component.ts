import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastService } from './../../../core/services/toast.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { disableCursor } from '@fullcalendar/core';

@Component({
  selector: 'app-cliente-details',
  templateUrl: './cliente-details.component.html',
  styleUrls: ['./cliente-details.component.css']
})
export class ClienteDetailsComponent implements OnInit {

  id: any;

  constructor(
    private router: ActivatedRoute,
    private toastService: ToastService,
    private route: Router,
    private fb: FormBuilder
  ) {

    this.id = this.router.snapshot.params['id'];


    }

  ngOnInit(): void {
  }



  onBack(): void {

    this.route.navigate(['main/clientes']);
  }

}
