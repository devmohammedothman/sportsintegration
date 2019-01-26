import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Activity } from '../models/activity.model';
import { HttpClient } from  "@angular/common/http";
import { map } from 'rxjs/operators';
@Injectable()
export class ActivityService
{

    private baseUrl = 'http://localhost:8080/sports/api';
    private serviceUrl = this.baseUrl+'/activity';

    constructor (private httpClient:HttpClient){}
    getCurrentActivities():Observable<any>
    {
        console.log('service calles');
        return this.httpClient.get<any>(this.serviceUrl);
    }


}