import {Component, OnInit} from '@angular/core';
import {BnkSeekService} from "../../services/bnk-seek.service";
import {ShortBnkSeek} from "../../domain/short-bnk-seek";
import {Pzn} from "../../domain/pzn";

declare const $: any;

@Component({
  selector: 'app-bnkseek-list',
  templateUrl: './bnkseek-list.component.html',
  styleUrls: ['./bnkseek-list.component.scss']
})
export class BnkseekListComponent implements OnInit {
  shortBnkSeek: ShortBnkSeek[] = [];
  pzn: Pzn[];
  inputValue: string;
  selectValue: string = 'newnum';
  valuePzn: string = '';

  constructor(private bnkSeekService: BnkSeekService) {
  }

  ngOnInit() {
    this.load();
  }

  onLoad() {
    this.load();
  }

  search() {
    if (this.selectValue == 'newnum' || this.selectValue == 'rgn') {
      this.bnkSeekService.search(this.inputValue, this.selectValue)
        .subscribe(data => this.shortBnkSeek = data,
          error => console.log(error)
        );
    }
    else {
      this.bnkSeekService.search(this.valuePzn, this.selectValue)
        .subscribe(data => this.shortBnkSeek = data,
          error => console.log(error)
        );
    }
  }

  hideShow() {
    if (this.selectValue == 'newnum' || this.selectValue == 'rgn') {
      $("#selectPzn").prop('disabled', true);
      $("#inputValue").prop('disabled', false);
    }
    else {
      $("#selectPzn").prop('disabled', false);
      $("#inputValue").prop('disabled', true);
    }
  }

  private load() {
    this.bnkSeekService.getBnkSeek().subscribe(
      data => this.shortBnkSeek = data,
      error => console.log(error)
    );
    this.bnkSeekService.getPzn().subscribe(
      data => this.pzn = data,
      error => console.log(error)
    );
  }
}
