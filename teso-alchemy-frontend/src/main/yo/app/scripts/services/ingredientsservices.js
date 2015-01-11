'use strict';

/**
 * @ngdoc service
 * @name tesoAlchemyApp.ingredientsServices
 * @description
 * # ingredientsServices
 * Service in the tesoAlchemyApp.
 */
angular.module('tesoAlchemyApp')
  .factory('IngredientService', function (Restangular) {
    return {
      /**
       * Returns all ingredients.
       * @returns {*}
       */
      all: function () {
        return Restangular.all('ingredients').getList().$object;
      },
      /**
       * Returns specifics ingredient.
       * @param id the id of the ingredient to find.
       * @returns {*}
       */
      one: function (id) {
        return Restangular.one('ingredients', id).get().$object;
      },
      /**
       * Returns the list of ingredients compatible with parameters.
       * @param id1 ingredient 1
       * @param id2 ingredient 2 (optional)
       * @returns {*}
       */
      findCompatible: function (id1, id2) {
        return Restangular.all('ingredients').all('compatibles').getList(
          {
            ref1: id1,
            ref2: (typeof id2 !== 'undefined' ? id2 : '')
          }
        ).$object;
      }
    }
  });
