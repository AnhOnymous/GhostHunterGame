/*
 * package edu.virginia.cs2110.ghosthuntergame;
 * 
 * 
 * private class AsyncTask1 extends AsyncTask<LatLng, void, boolean> {
 * 
 * boolean xTrue; boolean yTrue; int index; double xRange; double yRange;
 * 
 * @Override protected void onPreExecute(){
 * 
 * xTrue = false; yTrue = false; index = 0; //may need to specify which bones we
 * are picking up xRange = 0.0000034716614 * 5; yRange = 0.00000274602523 * 5;
 * 
 * }
 * 
 * @Override protected boolean doInBackground(Object... params){ //will need to
 * pass in the
 * 
 * double playerLong = params[0].getPlayerLongitude(); double playerLat =
 * params[0].getPlayerLatitude();
 * 
 * for(int i = 0; i < params[1].size(); i++){
 * if(Math.abs(params[1].get(i).getLongitude() - playerLong) <= xRange){ xTrue =
 * true; } if(Math.abs(params[1].get(i).getLatitude() - playerLat) <= yRange){
 * yTrue = true; } } if(xTrue == true && yTrue == true){ return true; } return
 * false; }
 * 
 * @Override protected void onPostExecute(boolean retval) {
 * 
 * if(newPlayer.getCurrentHp() > 0 ){ try{ Thread.sleep(1000) }
 * Thread.sleep(1000); task = new AsyncTask1(); task.execute(newPlayer,
 * ghostList); } } }
 */