import { trigger, state, style, transition, animate } from '@angular/animations';

export const slideInAnimation = trigger('slideIn', [
  state('hidden', style({ opacity: 0, transform: 'translateX(-100px)' })),  
  state('visible', style({ opacity: 1, transform: 'translateX(0)' })),
  transition('hidden => visible', animate('1000ms cubic-bezier(0.25, 1, 0.5, 1)'))
]);
