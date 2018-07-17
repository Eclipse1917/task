import {Component, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {FullBnkSeek} from "../../domain/full-bnk-seek";
import {BnkSeekService} from "../../services/bnk-seek.service";
import {Pzn} from "../../domain/pzn";
import {Reg} from "../../domain/reg";
import {Uer} from "../../domain/uer";
import {Tnp} from "../../domain/tnp";
import {BnkseekListComponent} from "../bnkseek-list/bnkseek-list.component";

declare const $: any;

@Component({
  selector: 'app-bnksee-edit-modal',
  templateUrl: './bnksee-edit-modal.component.html',
  styleUrls: ['./bnksee-edit-modal.component.scss']
})
export class BnkseeEditModalComponent implements OnInit {
  @Output() save = new EventEmitter;
  @ViewChild('bnkseekEditForm') form: NgForm;
  fullBnkSeek: FullBnkSeek;
  pzn: Pzn[] = [];
  uer: Uer[] = [];
  tnp: Tnp[] = [];
  reg: Reg[] = [];

  constructor(private bnkseekService: BnkSeekService, private bnkListComp: BnkseekListComponent) {
    this.clear();
  }

  ngOnInit() {
    $(document).ready(function () {
      $('#bnkseekEditModal').modal(
        {
          dismissible: false
        }
      );
    });
  }

  closeOnDelete() {
    this.onCancel();
    this.bnkListComp.onLoad();
  }

  onAdd() {
    this.clear();
    this.getAllSelect();
    this.addElements();
    this.show();
  }

  getAllSelect() {
    this.bnkseekService.getPzn().subscribe(
      data => {
        this.pzn = data;
      },
      error => console.log(error)
    );
    this.bnkseekService.getTnp().subscribe(
      data => {
        this.tnp = data;
      },
      error => console.log(error)
    );
    this.bnkseekService.getReg().subscribe(
      data => {
        this.reg = data;
      },
      error => console.log(error)
    );
    this.bnkseekService.getUer().subscribe(
      data => {
        this.uer = data;
      },
      error => console.log(error)
    );
  }

  onEdit(vkey: string) {
    this.bnkseekService.getBnkSeekByVkey(encodeURIComponent(vkey)).subscribe(
      data => {
        this.fullBnkSeek = data;
      },
      error => console.log(error)
    );
    this.getAllSelect();
    this.editElements();
    this.show();
  }

  editElements() {
    $("#DATE_IN").parent().show();
    $("#DT_IZM").parent().show();
    $("#NAMEN").parent().hide();
    $("#NEWKS").parent().hide();
    $("#PERMFO").parent().hide();
    $("#SROK").parent().hide();
    $("#AT1").parent().hide();
    $("#AT2").parent().hide();
    $("#CKS").parent().hide();
    $("#VKEYDEL").parent().hide();
    $("#DA_IZMR").parent().hide();
    $("#delete").show();
  }

  addElements() {
    $("#DATE_IN").parent().hide();
    $("#DT_IZM").parent().hide();
    $("#NAMEN").parent().show();
    $("#NEWKS").parent().show();
    $("#PERMFO").parent().show();
    $("#SROK").parent().show();
    $("#AT1").parent().show();
    $("#AT2").parent().show();
    $("#CKS").parent().show();
    $("#VKEYDEL").parent().show();
    $("#DA_IZMR").parent().show();
    $("#delete").hide();
  }

  onSave() {
    if (this.fullBnkSeek.vkey == '') {
      this.bnkseekService.createBnkSeek(this.fullBnkSeek).subscribe(
        _ => {
          this.save.emit();
          this.clear();
          this.close();
          this.reset();
        },
        error => console.log(error)
      );
    }
    else {
      this.bnkseekService.updateBnkSeek(encodeURIComponent(this.fullBnkSeek.vkey), this.fullBnkSeek).subscribe(
        _ => {
          this.save.emit();
          this.clear();
          this.close();
          this.reset();
        },
        error => console.log(error)
      );
    }
  }

  onCancel() {
    this.clear();
    this.close();
    this.reset();
  }

  private clear() {
    this.fullBnkSeek = new FullBnkSeek('', '', '', '', '', '', '', '', '',
      '', '', '', '', '', '', '', '', '', '', '', '',
      '', '', '', '', '', '', '');
  }

  private close() {
    $('#bnkseekEditModal').modal('close');
  }

  private reset() {
    this.form.reset();
  }

  private show() {
    $('#bnkseekEditModal').modal('open');
  }
}

