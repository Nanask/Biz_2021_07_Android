package com.callor.hello

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.callor.hello.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /**
     * NoActionBar Theme 화면에서
     * Custom 한 AcitonBar(title bar)를 생성하기 위한 클래스
     */

    private lateinit var appBarConfiguration: AppBarConfiguration
//    res/layout/activity_main.xml 파일을 클래스코에서 핸들링을 할 때는
//    xml 파일을 사용하여 자동으로 클래스가 생성된다.
//    xml 파일을 만들어놓으면 이렇게 클래스로 사용할 수 있게 한다.
//    사용되게 하려면 xml 이 클래스로 자동으로 변경된다 신기방기
    private lateinit var binding: ActivityMainBinding

//    Android App 에서 화면 View 와 관련된 클래스
//    main() 진입점 클래스
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    /**
     * activity_main.xml 의 view Component 를 한꺼번에 바인딩 하기 위한 코드
     * 예) 과거의 Java 코드에서 xml 에 포함된 view Component 들을 사용하기 위하여 초기화  다음과 같은 코드를
     * 사용하지 않는다.
     * 한번 바인딩 해주면 밑에 코드처럼 사용하지 않고 바로 사용할 수 있게 된다.
     * TextEdit textEdit = findById(R.Id.txt_01)
     */
        binding = ActivityMainBinding.inflate(layoutInflater)
    /**
     * activity_main.xml 전체를 확장하여 처음 어플 화면에 보여라
     * inflate를 하게 되면 root 라는 것이 생긴다.
     * 이 root는 컴포넌트 하나하나를 모아놓은 전체를 갖고 있다.
     */
        setContentView(binding.root)
//  임의로 생성한 ActionBar를 현재 화면에 같이 부착하라
//   id가 Toolbar 인 ActionBar 컴포넌트를 현재 화며에 부착하라.
        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}