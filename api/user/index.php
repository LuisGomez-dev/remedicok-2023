<?php
define("PROJECT_ROOT_PATH", __DIR__);
//echo PROJECT_ROOT_PATH;

// include main configuration file
require_once PROJECT_ROOT_PATH . "/inc/bootstrap.php";

$uri = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);
$uri = explode( '/', $uri );



if ((isset($uri[3]) && $uri[3] != 'user') || !isset($uri[3])) {
    header("HTTP/1.1 404 Not Found");
    exit();
}


require PROJECT_ROOT_PATH . "/Controller/UserController.php";


$objFeedController = new UserController();
$strMethodName = $uri[6] . 'Action';
$objFeedController->{$strMethodName}();

?>