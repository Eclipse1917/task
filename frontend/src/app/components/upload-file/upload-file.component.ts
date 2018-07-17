import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {BnkSeekService} from "../../services/bnk-seek.service";
import {HttpResponse} from "@angular/common/http";

declare const $: any;

@Component({
  selector: 'app-upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.scss']
})
export class UploadFileComponent implements OnInit {
  selectedFiles: FileList;
  currentFileUpload: File;
  @Output() save = new EventEmitter;

  constructor(private service: BnkSeekService) {
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  ngOnInit() {
    $(document).ready(function () {
      $('#upload_modal').modal(
        {
          dismissible: false
        }
      );
    });
  }

  upload() {
    this.currentFileUpload = this.selectedFiles.item(0);
    this.service.upload(this.currentFileUpload).subscribe(event => {
      if (event instanceof HttpResponse) {
        this.save.emit();
        this.close();
      }
    });

    this.currentFileUpload = undefined
  }

  onAdd() {
    this.show();
  }

  onCancel() {
    this.close();
  }

  private show() {
    $('#upload_modal').modal('open');
  }

  private close() {
    $('#upload_modal').modal('close');
  }

}
