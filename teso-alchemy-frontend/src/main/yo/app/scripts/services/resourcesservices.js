'use strict';

/**
 * @ngdoc service
 * @name tesoAlchemyApp.resourcesServices
 * @description
 * # resourcesServices
 * Service in the tesoAlchemyApp.
 */
angular.module('tesoAlchemyApp')
  .factory('CacheResources', function () {
    return {};
  })
  .factory('ResourcesServices', function (Restangular, CacheResources) {
    return {
      /**
       * Returns images of ingredients.
       */
      ingredientsImages: function () {
        if (CacheResources['ingredient'] == null) {
          CacheResources['ingredient'] = Restangular.all('resources').all('images').get('ingredients').$object;
        }
        return CacheResources['ingredient'];
      }
    }
  });
