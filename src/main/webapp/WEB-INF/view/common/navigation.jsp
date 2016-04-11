<!-- 
        NAME:       navigation.html
        DATE:       March 12, 2016
        AUTHOR:     Ananthakrishnan Prakash
        PURPOSE:    Includes all navigation elements used in the application (header-bar and side-bar navigation).
 -->

<!-- BEGIN: Navigation options, header-bar and side-bar; March 12, 2016 - Ananthakrishnan -->
<nav class = "navbar navbar-inverse navbar-fixed-top" role = "navigation">
    <div class = "navbar-header">
        <a class = "navbar-brand" href = "index.html">SB Admin</a>
    </div>
    
    <!-- BEGIN: Header-bar navigation options (main navigation); March 12, 2016 - Ananthakrishnan -->
    <ul class = "nav navbar-right top-nav">
        <li>
            <a href = "#"><i class = "fa fa-user"></i> Ananthakrishnan Prakash</a><!-- March 12, 2016 - Ananthakrishnan: Login user full name goes here -->
        </li>
        <li>
            <a href = "logout"><i class = "fa fa-fw fa-gear"></i>Logout</a><!-- March 12, 2016 - Ananthakrishnan: Logout button goes here -->
        </li>
    </ul>
    <!-- END: Header-bar navigation options (main navigation); March 12, 2016 - Ananthakrishnan -->
    
    <!-- BEGIN: Side-bar navigation options; March 12, 2016 - Ananthakrishnan -->
    <div class = "collapse navbar-collapse navbar-ex1-collapse">
        <ul class = "nav navbar-nav side-nav">
            <li class = "active">
                <a href = "view"><i class = "fa fa-fw fa-dashboard"></i>View User List</a>
            </li>
            <li>
                <a href = "addUser"><i class = "fa fa-fw fa-bar-chart-o"></i>Add New User</a>
            </li>
        </ul>
    </div>
    <!-- END: Side-bar navigation options; March 12, 2016 - Ananthakrishnan -->
    
</nav>
<!-- END: Navigation options, header-bar and side-bar; March 12, 2016 - Ananthakrishnan -->