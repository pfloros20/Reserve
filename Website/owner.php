<?php
	class Owner{

		public $ID;
		public $Username;
		public $Password;
		public $Stores = array();

		function __construct($ID,$Username,$Password,$Stores){
			$this->ID = $ID;
			$this->Username = $Username;
			$this->Password = $Password;
			$this->Stores = $Stores;
		}
	}
?>