import {Injectable} from '@angular/core';
import {HttpClient, HttpEvent} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {ShortBnkSeek} from "../domain/short-bnk-seek";
import {environment} from "../../environments/environment";
import {FullBnkSeek} from "../domain/full-bnk-seek";
import {Pzn} from "../domain/pzn";
import {Reg} from "../domain/reg";
import {Uer} from "../domain/uer";
import {Tnp} from "../domain/tnp";

@Injectable()
export class BnkSeekService {

  constructor(private http: HttpClient) {
  }

  getBnkSeek(): Observable<ShortBnkSeek[]> {
    return this.http.get<ShortBnkSeek[]>(`${environment.api}/bnkseek`);
  }

  getBnkSeekByVkey(vkey: string): Observable<FullBnkSeek> {
    return this.http.get<FullBnkSeek>(`${environment.api}/bnkseek/${vkey}`)
  }

  getReg(): Observable<Reg[]> {
    return this.http.get<Reg[]>(`${environment.api}/bnkseek/getReg`)
  }

  getPzn(): Observable<Pzn[]> {
    return this.http.get<Pzn[]>(`${environment.api}/bnkseek/getPzn`)
  }

  getUer(): Observable<Uer[]> {
    return this.http.get<Uer[]>(`${environment.api}/bnkseek/getUer`)
  }

  getTnp(): Observable<Tnp[]> {
    return this.http.get<Tnp[]>(`${environment.api}/bnkseek/getTnp`)
  }

  createBnkSeek(bnkSeek: FullBnkSeek): Observable<any> {
    return this.http.post(`${environment.api}/bnkseek`,
      bnkSeek,
      {
        responseType: 'text',
        observe: 'response'
      }
    );
  }

  updateBnkSeek(vkey: string, bnkSeek: FullBnkSeek): Observable<any> {
    return this.http.put(`${environment.api}/bnkseek/${vkey}`,
      bnkSeek,
      {
        responseType: 'text',
        observe: 'response'
      }
    );
  }

  removeBnkSeek(vkey: string): Observable<any> {
    return this.http.delete(`${environment.api}/bnkseek/${vkey}`,
      {
        responseType: 'text',
        observe: 'response'
      }
    );
  }

  upload(file: File): Observable<HttpEvent<{}>> {
    let formdata: FormData = new FormData();
    formdata.append('file', file);
    return this.http.post(`${environment.api}/bnkseek/upload`, formdata,
      {
        responseType: 'text',
        observe: 'response'
      })
  }

  search(value: string, param: string): Observable<ShortBnkSeek[]> {
    return this.http.get<ShortBnkSeek[]>(`${environment.api}/bnkseek/${param}?${param}=${value}`)
  }
}
