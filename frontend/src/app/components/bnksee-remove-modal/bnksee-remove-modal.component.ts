import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {BnkSeekService} from "../../services/bnk-seek.service";
import {FullBnkSeek} from "../../domain/full-bnk-seek";

declare const $: any;

@Component({
  selector: 'app-bnksee-remove-modal',
  templateUrl: './bnksee-remove-modal.component.html',
  styleUrls: ['./bnksee-remove-modal.component.scss']
})
export class BnkseeRemoveModalComponent implements OnInit {
  @Output() delete = new EventEmitter;
  bnkSeek: FullBnkSeek;

  constructor(private service: BnkSeekService) {
  }

  ngOnInit() {
    $(document).ready(function () {
      $('#BnkseekRemoveModal').modal(
        {
          dismissible: false,
          endingTop: '15%'
        }
      );
    });
  }

  onRemove(bnkSeek: FullBnkSeek) {
    this.bnkSeek = bnkSeek;
    this.show();
  }

  onDelete() {
    this.service.removeBnkSeek(encodeURIComponent(this.bnkSeek.vkey)).subscribe(
      _ => {
        this.delete.emit();
        this.close();
      },
      error => console.log(error)
    );
  }

  onCancel() {
    this.close();
  }

  private close() {
    $('#BnkseekRemoveModal').modal('close');
  }

  private show() {
    $('#BnkseekRemoveModal').modal('open');
  }

}
