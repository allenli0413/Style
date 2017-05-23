package com.yalin.style.data.entity.mapper;

import com.fernandocejas.arrow.checks.Preconditions;
import com.yalin.style.data.entity.SourceEntity;
import com.yalin.style.data.entity.WallpaperEntity;
import com.yalin.style.domain.Source;
import com.yalin.style.domain.Wallpaper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author jinyalin
 * @since 2017/4/18.
 */
@Singleton
public class WallpaperEntityMapper {

    @Inject
    public WallpaperEntityMapper() {
    }

    public Wallpaper transform(WallpaperEntity wallpaperEntity) {
        Preconditions.checkNotNull(wallpaperEntity, "Wallpaper can not be null.");
        Wallpaper wallpaper = new Wallpaper();
        wallpaper.title = wallpaperEntity.title;
        wallpaper.attribution = wallpaperEntity.attribution;
        wallpaper.byline = wallpaperEntity.byline;
        wallpaper.imageUri = wallpaperEntity.imageUri;
        wallpaper.wallpaperId = wallpaperEntity.wallpaperId;
        wallpaper.liked = wallpaperEntity.liked;
        wallpaper.isDefault = wallpaperEntity.isDefault;
        return wallpaper;
    }

    public List<Source> transformSources(List<SourceEntity> sourceEntities) {
        Preconditions.checkNotNull(sourceEntities, "SourceEntity can not be null.");
        List<Source> sources = new ArrayList<>();
        for (SourceEntity entity : sourceEntities) {
            sources.add(transformSource(entity));
        }
        return sources;
    }

    public Source transformSource(SourceEntity sourceEntity) {
        Preconditions.checkNotNull(sourceEntity, "SourceEntity can not be null.");
        Source source = new Source();
        source.id = sourceEntity.getId();
        source.title = sourceEntity.getTitle();
        source.description = sourceEntity.getDescription();
        source.iconId = sourceEntity.getIconId();
        source.selected = sourceEntity.isSelected();
        source.hasSetting = sourceEntity.isHasSetting();
        source.color = sourceEntity.getColor();
        return source;
    }
}
