import { Component } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { ActivityService } from './services/activity.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  title = 'Current Strava Activities Are:';

  displayedColumns = ['ID','Name','Distance', 'StartDate'];
  dataSource = new MatTableDataSource();

  constructor(private apiService:ActivityService){}

  //9c6a2b374e7f901a9184360536a807b55acdce9c
  ngOnInit() {
    this.apiService.getCurrentActivities().subscribe(
      data => {
        console.log(data);
        this.dataSource.data = data.data;
      }
    );
  }

}
