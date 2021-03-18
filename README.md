3/.18/2020
# Check Network Connectivity

I needed a way to check network connectivity for a project.  After some research I found
an excellent article on <a href="https://evanschepsiror.medium.com/checking-androids-network-connectivity-with-network-callback-fdb8d24a920c">Medium by Evans Chepsiror</a>.  His code is posted here
on <a href="https://github.com/evans-chepsiror/Callback_Demo">github</a>.  It covered 
Android's Network Callback library which is only usable on Android 21 and newer.
  
I also wanted to cover Android 4.4.  This is his code with modifications to support a polled 
mode for API 19 forward and a trivial user interface.

<center>
  <summary>Demo app screenshot</summary>
  <img alt="demo app screenshot" src="https://github.com/bebop-001/CheckNetworkConnectivity/blob/main/resources/screenshot.png?raw=true">
</center>
