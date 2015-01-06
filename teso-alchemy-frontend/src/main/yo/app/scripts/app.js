'use strict';

/**
 * @ngdoc overview
 * @name tesoAlchemyApp
 * @description
 * # tesoAlchemyApp
 *
 * Main module of the application.
 */
angular
  .module('tesoAlchemyApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/ingredients', {
        templateUrl: 'views/ingredients.html',
        controller: 'IngredientsCtrl'
      })
      .when('/effects', {
        templateUrl: 'views/effects.html',
        controller: 'EffectsCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
