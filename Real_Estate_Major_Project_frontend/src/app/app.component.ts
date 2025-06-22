import { Component, ViewEncapsulation } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {
  trigger,
  transition,
  style,
  animate,
  query,
  group
} from '@angular/animations';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  encapsulation: ViewEncapsulation.None,
  animations: [
    trigger('routeAnimations', [
      transition('* <=> *', [
        // Set initial state for container
        style({ position: 'relative' }),
        
        // Query both elements
        query(':enter, :leave', [
          style({
            position: 'absolute',
            top: 0,
            left: 0,
            width: '100%',
            minHeight: 'calc(100vh - 64px)'
          })
        ], { optional: true }),
        
        // Animate simultaneously
        group([
          // Animate leaving element
          query(':leave', [
            animate('700ms cubic-bezier(0.4, 0.0, 0.2, 1)', 
              style({ 
                opacity: 0,
                transform: 'scale(0.98) translateY(20px)'
              })
            )
          ], { optional: true }),
          
          // Animate entering element
          query(':enter', [
            style({ 
              opacity: 0,
              transform: 'scale(1.02)'
            }),
            animate('700ms 100ms cubic-bezier(0.4, 0.0, 0.2, 1)', 
              style({ 
                opacity: 1,
                transform: 'scale(1) translateY(0)'
              })
            )
          ], { optional: true })
        ])
      ])
    ])
  ]
})
export class AppComponent {
  title = 'Real_Estate_Major_Project';
  
  prepareRoute(outlet: RouterOutlet) {
    return outlet?.activatedRouteData?.['animation'] || 'primary';
  }
}