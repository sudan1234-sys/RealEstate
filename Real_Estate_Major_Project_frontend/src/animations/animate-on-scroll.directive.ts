import { Directive, ElementRef, AfterViewInit, Input } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';

/*
  Responsive animation distances
  Mobile → smaller movement
  Desktop → slide from sides
*/
const getDistance = () => {
  return window.innerWidth < 768
    ? { x: 0, y: 60 }      // mobile → slide up
    : { x: 120, y: 80 };   // desktop → side slides
};

const ANIMATIONS = {
  up: trigger('scrollUp', [
    state('hidden', style({
      opacity: 0,
      transform: `translateY(${getDistance().y}px)`
    })),
    state('visible', style({
      opacity: 1,
      transform: 'translateY(0)'
    })),
    transition('hidden => visible', animate('700ms ease-out'))
  ]),

  left: trigger('scrollLeft', [
    state('hidden', style({
      opacity: 0,
      transform: window.innerWidth < 768
        ? `translateY(${getDistance().y}px)`     // mobile
        : `translateX(-${getDistance().x}px)`    // desktop
    })),
    state('visible', style({
      opacity: 1,
      transform: 'translate(0,0)'
    })),
    transition('hidden => visible', animate('700ms ease-out'))
  ]),

  right: trigger('scrollRight', [
    state('hidden', style({
      opacity: 0,
      transform: window.innerWidth < 768
        ? `translateY(${getDistance().y}px)`
        : `translateX(${getDistance().x}px)`
    })),
    state('visible', style({
      opacity: 1,
      transform: 'translate(0,0)'
    })),
    transition('hidden => visible', animate('700ms ease-out'))
  ])
};

@Directive({
  standalone: true,
  selector: '[appAnimate]',
  host: {
    '[@scrollUp]': 'upState',
    '[@scrollLeft]': 'leftState',
    '[@scrollRight]': 'rightState',
    '[@.disabled]': 'false'
  }
})
export class AnimateOnScrollDirective implements AfterViewInit {

  @Input() animationType: 'up' | 'left' | 'right' = 'up';

  upState: 'hidden' | 'visible' = 'hidden';
  leftState: 'hidden' | 'visible' = 'hidden';
  rightState: 'hidden' | 'visible' = 'hidden';

  constructor(private el: ElementRef) {}

  ngAfterViewInit() {
    const observer = new IntersectionObserver(
      entries => {
        entries.forEach(entry => {
          if (entry.isIntersecting) {
            this.triggerAnimation();
            observer.unobserve(this.el.nativeElement);
          }
        });
      },
      {
        threshold: 0.15,
        rootMargin: '0px 0px -50px 0px'
      }
    );

    observer.observe(this.el.nativeElement);
  }

  private triggerAnimation() {
    switch (this.animationType) {
      case 'up':
        this.upState = 'visible';
        break;
      case 'left':
        this.leftState = 'visible';
        break;
      case 'right':
        this.rightState = 'visible';
        break;
    }
  }
}

export const SCROLL_ANIMATIONS = [
  ANIMATIONS.up,
  ANIMATIONS.left,
  ANIMATIONS.right
];
