'use strict';

describe('Service: ingredientsServices', function () {

  // load the service's module
  beforeEach(module('tesoAlchemyApp'));

  // instantiate service
  var ingredientsServices;
  beforeEach(inject(function (_ingredientsServices_) {
    ingredientsServices = _ingredientsServices_;
  }));

  it('should do something', function () {
    expect(!!ingredientsServices).toBe(true);
  });

});
