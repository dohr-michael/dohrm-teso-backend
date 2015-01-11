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
    'restangular',
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
      .when('/compo', {
        templateUrl: 'views/compo.html',
        controller: 'CompoCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  })
  .config(function (RestangularProvider) {
    RestangularProvider.setBaseUrl("http://localhost:8080");
    //RestangularProvider.setBaseUrl("http://backend.dohrm.fr/teso");
  });
