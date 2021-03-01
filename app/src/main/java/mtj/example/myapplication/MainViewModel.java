package mtj.example.myapplication;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainViewModel extends AndroidViewModel {
    private BlogRepository blogRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        blogRepository = new BlogRepository(application);

    }

    public LiveData<List<Blog>> getAllBlog(){
        return blogRepository.getMutableLiveData();
    }
}
