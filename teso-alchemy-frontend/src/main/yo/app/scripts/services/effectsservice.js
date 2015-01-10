'use strict';

/**
 * @ngdoc service
 * @name tesoAlchemyApp.effectsService
 * @description
 * # effectsService
 * Service in the tesoAlchemyApp.
 */
angular.module('tesoAlchemyApp')
  .factory('Effect', function (Restangular) {
    return {
      /**
       * Return all effect.
       * @returns {*}
       */
      all: function () {
        return Restangular.all('effects').getList().$object;
      }
    }
  });
