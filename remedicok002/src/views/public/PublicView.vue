<template>
    <div class="public">

        <div class="container text-center">
            <div class="row">
                <div class="col-md-6 offset-md-3">

                    <div class="card">
                        <div class="card-header">
                            Acceso
                        </div>
                        <div class="card-body">
                            <form>
                                <div class="row mb-3">
                                    <label for="inputEmail3" class="col-sm-2 col-form-label">Usuario</label>
                                    <div class="col-sm-10">
                                    <input type="email" class="form-control" id="inputEmail3">
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="inputPassword3" class="col-sm-2 col-form-label">Clave</label>
                                    <div class="col-sm-10">
                                    <input type="password" class="form-control" id="inputPassword3">
                                    </div>
                                </div>
                                <fieldset class="row mb-3">
                                </fieldset>
                                <button type="submit" class="btn btn-primary">Login</button>
                            </form>
                        </div>
                    </div>



                </div>
            </div>
        </div>


    </div>
  </template>
  
  <script>
    
  export default {
    name: 'PublicView',
  }
  </script>